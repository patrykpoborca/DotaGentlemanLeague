package io.ppoborca.dotagentlemanleague.base.activity

import io.ppoborca.dotagentlemanleague.base.BaseView
import io.ppoborca.dotagentlemanleague.base.BaseViewIMPL
import io.ppoborca.dotagentlemanleague.base.viewmodel.BaseViewModel
import rx.Scheduler

open abstract public class ViewModelActivity<T : BaseViewModel> : BaseActivity(), BaseView<T> by BaseViewIMPL<T>() {

    abstract fun injectThis()

    public var mainScheduler : Scheduler? = null;
        get(){
            return getViewModel().mainScheduler
        }

}

