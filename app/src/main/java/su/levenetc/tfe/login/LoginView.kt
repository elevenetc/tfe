package su.levenetc.tfe.login

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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
            result.retainInstance = true
            return result
        }
    }

    private lateinit var btnLogin: Button
    private lateinit var editName: EditText
    private lateinit var router: Router

    private var viewMode: LoginViewModel = LoginViewModel()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val result = inflater?.inflate(R.layout.view_login, container, false)

        btnLogin = result?.findViewById(R.id.btn_login)!!
        editName = result.findViewById(R.id.edit_name)

        return result
    }

}