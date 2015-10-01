package io.ppoborca.dotagentlemanleague.ui.root

import io.ppoborca.dotagentlemanleague.base.viewmodel.BaseViewModel
import rx.Observable
import rx.subjects.BehaviorSubject
import javax.inject.Inject

public class MainActivityViewModel @Inject constructor() : BaseViewModel(){
    val currentScreenStream : BehaviorSubject<Screens>

    init {
         currentScreenStream = BehaviorSubject.create();
    }


    public enum class Screens {
        HOME
    }
}
