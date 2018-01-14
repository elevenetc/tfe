package su.levenetc.tfe.login

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import su.levenetc.tfe.R
import su.levenetc.tfe.routing.Router

/**
 * Created by eugene.levenetc on 01/12/2017.
 */
class LoginView : Fragment() {

    companion object {
        fun newInstance(router: Router): LoginView {
            val result = LoginView()
            result.router = router
            return result
        }
    }

    private lateinit var btnLogin: Button
    private lateinit var editName: EditText
    private lateinit var textStatus: TextView
    private lateinit var router: Router

    private var stateSub: Disposable? = null

    private var viewModel: LoginViewModel = LoginViewModel()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val result = inflater?.inflate(R.layout.view_login, container, false)

        btnLogin = result?.findViewById(R.id.btn_login)!!
        editName = result.findViewById(R.id.edit_name)
        textStatus = result.findViewById(R.id.text_status)

        return result
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stateSub = viewModel.stateObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleState)
    }

    override fun onDestroyView() {
        stateSub?.dispose()
        super.onDestroyView()
    }

    private fun handleState(state: LoginState) {
        if (state == LoginState.ERROR) {
            textStatus.text = "Error"
        } else {
            textStatus.text = ""

            if (state == LoginState.IDLE) {

            } else if (state == LoginState.LOGGING_IN) {
                textStatus.text = "Logging in..."
            } else if (state == LoginState.SUCCESS) {
                textStatus.text = "Logged in successfully"
            }
        }
    }
}