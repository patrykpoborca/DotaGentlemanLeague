package io.ppoborca.dotagentlemanleague.dagger.components

import android.content.Context
import dagger.Component
import io.ppoborca.dotagentlemanleague.ui.root.MainActivity
import io.ppoborca.dotagentlemanleague.dagger.modules.ApplicationModule

@Component(modules = arrayOf(ApplicationModule::class))
interface BaseComponent{

    fun providesContext() : Context;

    fun inject(o : Any);

    fun inject(activity : MainActivity);
}

