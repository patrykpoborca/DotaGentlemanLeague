package io.ppoborca.dotagentlemanleague.dagger.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import io.ppoborca.dotagentlemanleague.utility.Constants
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Named

@Module
public class ApplicationModule(val context: Context){


    @Provides
    public fun providesContext () : Context {
        return context;
    }

    @Provides
    @Named(Constants.MAIN_THREAD)
    public fun providesMainThread() : Scheduler{
        return AndroidSchedulers.mainThread();
    }


}
