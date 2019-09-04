package com.namlu.airtasker

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.namlu.airtasker.adapters.FeedItemAdapter
import com.namlu.airtasker.models.FeedItem
import com.namlu.airtasker.models.FeedItemViewState
import com.namlu.airtasker.models.ProfileItem
import com.namlu.airtasker.models.TaskItem
import com.namlu.airtasker.requests.ServiceGenerator
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_feed_list.*

class FeedListActivity : BaseActivity() {

    private lateinit var feedItemAdapter: FeedItemAdapter

    val disposables = CompositeDisposable()

    companion object {
        const val TAG = "FeedListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_list)

        recycler_feed_list.apply {
            layoutManager = LinearLayoutManager(this@FeedListActivity)
            feedItemAdapter = FeedItemAdapter()
            adapter = feedItemAdapter
        }
        testFeedItemResponse()
    }

    // Get a list of feed items
    private fun testFeedItemResponse() {
        val api = ServiceGenerator.getApi()
        disposables.add(
            api
                .getFeedItemsObservable() // List<FeedItem>
                .flatMap {
                    Observable.fromIterable(it)
                } // FeedItem given one by one
                .switchMap {
                    Observable.zip(
                        Observable.just(it),
                        api.getProfileItemObservable(it.profile_id),
                        api.getTaskItemObservable(it.task_id),
                        Function3<FeedItem, ProfileItem, TaskItem, FeedItemViewState>
                        { feedItem, profileItem, taskItem ->
                            FeedItemViewState(feedItem, profileItem, taskItem)
                        }
                    )
                }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    feedItemAdapter.setFeedItems(it)
                }, {
                    it.printStackTrace()
                })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
