package io.ppoborca.dotagentlemanleague.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.trello.rxlifecycle.FragmentEvent
import com.trello.rxlifecycle.RxLifecycle
import com.trello.rxlifecycle.components.FragmentLifecycleProvider
import rx.Observable
import rx.subjects.BehaviorSubject

public open class BaseFragment : Fragment(), FragmentLifecycleProvider{
    private val lifecycleSubject : BehaviorSubject<FragmentEvent> = BehaviorSubject.create();

    override fun lifecycle(): Observable<FragmentEvent>? {
        return lifecycleSubject;
    }

    override fun <T : Any?> bindToLifecycle(): Observable.Transformer<T, T>? {
        return RxLifecycle.bindFragment(lifecycleSubject);
    }

    override fun <T : Any?> bindUntilEvent(event: FragmentEvent?): Observable.Transformer<T, T>? {
        return RxLifecycle.bindUntilFragmentEvent(lifecycleSubject, event);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleSubject.onNext(FragmentEvent.CREATE);
    }

    override fun onStart() {
        super.onStart()
        lifecycleSubject.onNext(FragmentEvent.START);
    }

    override fun onResume() {
        super.onResume()
        lifecycleSubject.onNext(FragmentEvent.RESUME);
    }

    override fun onPause() {
        super.onPause()
        lifecycleSubject.onNext(FragmentEvent.PAUSE);
    }

    override fun onStop() {
        super.onStop()
        lifecycleSubject.onNext(FragmentEvent.STOP);
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleSubject.onNext(FragmentEvent.DESTROY);
    }
}
