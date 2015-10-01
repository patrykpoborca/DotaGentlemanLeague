package io.ppoborca.dotagentlemanleague.base

import io.ppoborca.dotagentlemanleague.base.viewmodel.BaseViewModel
import javax.inject.Inject

public open class BaseViewIMPL<T : BaseViewModel> : BaseView<T> {

    lateinit private var viewModel: T;

    @Inject
    override public fun injectViewModel(viewModel: T) {
        this.viewModel = viewModel;
    }

    override public fun getViewModel(): T {
        return viewModel;
    }
}
