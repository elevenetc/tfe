package su.levenetc.tfe.login

import io.reactivex.Observable

/**
 * Created by eugene.levenetc on 01/12/2017.
 */
class LoginViewModel {


    fun stateObservable(): Observable<LoginState> {

        return Observable.just(LoginState.IDLE)
    }

    fun login(name: String) {

    }
}