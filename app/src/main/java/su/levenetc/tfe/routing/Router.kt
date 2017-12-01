package su.levenetc.tfe.routing

import android.app.Activity
import su.levenetc.tfe.R
import su.levenetc.tfe.login.LoginView

/**
 * Created by eugene.levenetc on 01/12/2017.
 */
class Router {
    fun onContextViewCreated(context: Activity) {
        context.fragmentManager
                .beginTransaction()
                .add(
                        R.id.root_container,
                        LoginView.newInstance(this)
                ).commit()
    }
}