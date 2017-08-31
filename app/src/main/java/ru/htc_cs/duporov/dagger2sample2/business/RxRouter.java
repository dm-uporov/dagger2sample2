package ru.htc_cs.duporov.dagger2sample2.business;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

public class RxRouter<T> {

    private T data;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private BehaviorSubject<T> subject = BehaviorSubject.create();

    public RxRouter(T data) {
        this.data = data;
    }

    public Disposable subscribeOnData(Consumer<T> observer) {
        Disposable disposable = subject.subscribe(observer);
        compositeDisposable.add(disposable);
        return disposable;
    }

    public void unsubscribe(Disposable disposable) {
        compositeDisposable.remove(disposable);
    }

    public void setData(T data) {
        this.data = data;
        subject.onNext(data);
    }

    public T getData() {
        return data;
    }
}
