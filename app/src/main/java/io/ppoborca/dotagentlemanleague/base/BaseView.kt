package io.ppoborca.dotagentlemanleague.base

import io.ppoborca.dotagentlemanleague.base.viewmodel.BaseViewModel
public interface BaseView<T :BaseViewModel>{

    public fun injectViewModel(viewModel: T)

    public fun getViewModel(): T

}
