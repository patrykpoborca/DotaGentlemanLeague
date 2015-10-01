package io.ppoborca.dotagentlemanleague.ui.root.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.ppoborca.dotagentlemanleague.R
import io.ppoborca.dotagentlemanleague.base.fragment.ViewModelFragment
import io.ppoborca.dotagentlemanleague.dagger.components.DaggerBaseComponent
import io.ppoborca.dotagentlemanleague.dagger.modules.ApplicationModule

public class HomeFragment : ViewModelFragment<HomeViewModel>() {



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_home, container, false);
    }

    override fun injectThis() {
        DaggerBaseComponent.builder().applicationModule(ApplicationModule(activity.applicationContext)).build().inject(this);
    }

}


