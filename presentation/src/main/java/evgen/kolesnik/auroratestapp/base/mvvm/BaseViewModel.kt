package evgen.kolesnik.auroratestapp.base.mvvm

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel() : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun addToDisposable(disposable: Disposable?) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}