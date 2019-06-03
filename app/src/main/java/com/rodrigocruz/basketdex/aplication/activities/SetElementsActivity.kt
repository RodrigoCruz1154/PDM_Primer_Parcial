package com.rodrigocruz.basketdex.aplication.activities

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.rodrigocruz.basketdex.R
import kotlinx.android.synthetic.main.activity_set_elements.*
import java.text.SimpleDateFormat
import java.util.*

class SetElementsActivity : AppCompatActivity() {

    private lateinit var editTeam1 : EditText
    private lateinit var editTeam2 : EditText

    private lateinit var editEstadio : EditText
    private lateinit var editReferee : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_elements)

        editTeam1 = findViewById(R.id.editTextEquipo1)
        editTeam2 = findViewById(R.id.editTextEquipo2)
        editEstadio = findViewById(R.id.editNombreEstadio)
        editReferee = findViewById(R.id.editNombreReferee)

        //Obtener y setear Fecha del Calendario

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        //Mostrar diálogo de calendario
        EditTextFechaPartido.setOnClickListener {
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, myear, mmonth, mdayOfMonth ->
                fechaObtenida.setText(""+mdayOfMonth+"/"+mmonth+"/"+myear)
            },year,month,day)
            dpd.show()
        }

        //Obtener y setear Hora

        EditTextHoraPartido.setOnClickListener {
            val cal = Calendar.getInstance()
            val getTiempo = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                cal.set(Calendar.HOUR_OF_DAY,hourOfDay)
                cal.set(Calendar.MINUTE,minute)
                horaObtenida.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this,getTiempo,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()
        }

        //botones :u

        btnAccept.setOnClickListener {
            val intent:Intent = Intent(this, InGameActivity::class.java)
            val replyIntent = Intent()
            startActivity(intent)
            if(TextUtils.isEmpty(editTeam1.text)|| TextUtils.isEmpty(editTeam2.text)||TextUtils.isEmpty(editEstadio.text)||TextUtils.isEmpty(editReferee.text)){
                setResult(Activity.RESULT_CANCELED,replyIntent)
            } else{
                val equipo1 = editTeam1.text.toString()
                replyIntent.putExtra(EXTRA_REPLY,equipo1)

                val equipo2 = editTeam2.text.toString()
                replyIntent.putExtra(EXTRA_REPLY,equipo2)

                val estadio = editEstadio.text.toString()
                replyIntent.putExtra(EXTRA_REPLY,estadio)

                val referee = editReferee.text.toString()
                replyIntent.putExtra(EXTRA_REPLY,referee)

                setResult(Activity.RESULT_OK,replyIntent)
            }
            finish()
        }
        btnCancel.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }
    companion object{
        const val EXTRA_REPLY = "com.rodrigocruz.basketdex.wordlistsql.REPLY"
    }

}
