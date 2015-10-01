package io.ppoborca.dotagentlemanleague.base.viewmodel

import io.ppoborca.dotagentlemanleague.utility.Constants
import rx.Scheduler
import javax.inject.Named

open public class BaseViewModel{

    lateinit public var mainScheduler: Scheduler;

    fun injectDependencies(@Named(Constants.MAIN_THREAD) scheduler : Scheduler){
        mainScheduler = scheduler;
    }

}
