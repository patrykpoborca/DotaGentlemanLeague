package io.ppoborca.dotagentlemanleague.ui.root

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import butterknife.bindView
import com.firebase.client.Firebase
import com.trello.rxlifecycle.RxLifecycle
import io.ppoborca.dotagentlemanleague.R
import io.ppoborca.dotagentlemanleague.base.activity.ViewModelActivity
import io.ppoborca.dotagentlemanleague.base.fragment.BaseFragment
import io.ppoborca.dotagentlemanleague.dagger.components.DaggerBaseComponent
import io.ppoborca.dotagentlemanleague.dagger.modules.ApplicationModule
import io.ppoborca.dotagentlemanleague.ui.root.fragments.HomeFragment


public class MainActivity : ViewModelActivity<MainActivityViewModel>() {


    //region view variables
    val toolbar : Toolbar by bindView(R.id.toolbar)
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main);
        setSupportActionBar(toolbar)
        injectThis()
        initView();
        //val myFirebase: Firebase = Firebase("https://dml.firebaseio.com/users");
    }

    private fun initView() {
        getViewModel().currentScreenStream.observeOn(mainScheduler).compose<MainActivityViewModel.Screens>(RxLifecycle.bindActivity(lifecycle()))
                .subscribe { v -> loadCurrentScreen(v)}
    }

    private fun loadCurrentScreen(screen : MainActivityViewModel.Screens) {
        var transaction = supportFragmentManager.beginTransaction();
        var selectedFragment: BaseFragment;

        when(screen){
            MainActivityViewModel.Screens.HOME -> selectedFragment = HomeFragment()
        }
        transaction.replace(R.id.fragment_container, selectedFragment);
        transaction.commit();
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun injectThis() {
        DaggerBaseComponent.builder().applicationModule(ApplicationModule(applicationContext)).build().inject(this);
    }
}
