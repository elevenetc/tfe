package su.levenetc.tfe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import su.levenetc.tfe.routing.Router

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val router = Router()
        router.onContextViewCreated(this)
    }
}
