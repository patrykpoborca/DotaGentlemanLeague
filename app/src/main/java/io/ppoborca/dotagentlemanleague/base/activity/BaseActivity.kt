package io.ppoborca.dotagentlemanleague.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.trello.rxlifecycle.ActivityEvent
import com.trello.rxlifecycle.RxLifecycle
import com.trello.rxlifecycle.components.ActivityLifecycleProvider
import io.ppoborca.dotagentlemanleague.dagger.components.DaggerBaseComponent
import io.ppoborca.dotagentlemanleague.dagger.modules.ApplicationModule
import rx.Observable
import rx.subjects.BehaviorSubject

public open class BaseActivity : AppCompatActivity(), ActivityLifecycleProvider {

    private val lifecycleSubject : BehaviorSubject<ActivityEvent> = BehaviorSubject.create();

    override fun lifecycle(): Observable<ActivityEvent>? {
        return lifecycleSubject;
    }

    override fun <T : Any?> bindToLifecycle(): Observable.Transformer<T, T>? {
        return RxLifecycle.bindActivity(lifecycleSubject);
    }

    override fun <T : Any?> bindUntilEvent(event: ActivityEvent?): Observable.Transformer<T, T>? {
        return RxLifecycle.bindUntilActivityEvent(lifecycleSubject, event);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleSubject.onNext(ActivityEvent.CREATE);
    }

    override fun onStart() {
        super.onStart()
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    override fun onResume() {
        super.onResume()
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    override fun onPause() {
        super.onPause()
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
    }

    override fun onStop() {
        super.onStop()
        lifecycleSubject.onNext(ActivityEvent.STOP);
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
    }
}
