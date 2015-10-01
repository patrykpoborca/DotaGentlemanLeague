package io.ppoborca.dotagentlemanleague.base.fragment

import io.ppoborca.dotagentlemanleague.base.BaseView
import io.ppoborca.dotagentlemanleague.base.BaseViewIMPL
import io.ppoborca.dotagentlemanleague.base.viewmodel.BaseViewModel
import rx.Scheduler

public open abstract class ViewModelFragment<T : BaseViewModel> : BaseFragment(), BaseView<T> by BaseViewIMPL<T>(){

    protected abstract fun injectThis();

    public fun getMainScheduler() : Scheduler {
        return getViewModel().mainScheduler;
    }
}
