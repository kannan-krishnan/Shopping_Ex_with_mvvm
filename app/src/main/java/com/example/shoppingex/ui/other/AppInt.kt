package com.example.shoppingex.ui.other

import android.app.Application
import com.example.shoppingex.db.ShoppingDatabase
import com.example.shoppingex.repo.ShoppingRepo
import com.example.shoppingex.ui.shopping_list.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by #kannanpvm007 on  07/02/23.
 */
class AppInt :Application(),KodeinAware {
    override val kodein: Kodein =  Kodein.lazy {
        import(androidXModule(this@AppInt))
        bind() from singleton {
            ShoppingDatabase(instance())
        }
        bind() from singleton {
            ShoppingRepo(instance())
        }
        bind() from  provider {
            ShoppingViewModelFactory(instance())
        }
    }
}