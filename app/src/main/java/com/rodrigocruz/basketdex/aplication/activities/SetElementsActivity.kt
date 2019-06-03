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
import android.widget.TextView
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

    private lateinit var fechaget : TextView
    private lateinit var horaget : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_elements)

        editTeam1 = findViewById(R.id.editTextEquipo1)
        editTeam2 = findViewById(R.id.editTextEquipo2)
        editEstadio = findViewById(R.id.editNombreEstadio)
        editReferee = findViewById(R.id.editNombreReferee)
        fechaget = findViewById(R.id.fechaObtenida)
        horaget = findViewById(R.id.horaObtenida)

        //Obtener y setear Fecha del Calendario

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        //Mostrar diálogo de calendario
        EditTextFechaPartido.setOnClickListener {
            val intent : Intent = Intent(this,MainActivity::class.java)
            val fechita = fechaget.text.toString()
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, myear, mmonth, mdayOfMonth ->
                fechaObtenida.setText(""+mdayOfMonth+"/"+mmonth+"/"+myear)
            },year,month,day)
            dpd.show()
            intent.putExtra("fecha",fechita)
        }

        //Obtener y setear Hora

        EditTextHoraPartido.setOnClickListener {
            val cal = Calendar.getInstance()
            val intent : Intent = Intent(this,MainActivity::class.java)
            val horita = horaget.text.toString()
            val getTiempo = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                cal.set(Calendar.HOUR_OF_DAY,hourOfDay)
                cal.set(Calendar.MINUTE,minute)
                horaObtenida.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this,getTiempo,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()
            intent.putExtra("hora",horita)
        }

        //botones :u

        btnAccept.setOnClickListener {
            val intent:Intent = Intent(this, InGameActivity::class.java)
            val equipo1 = editTeam1.text.toString()
            intent.putExtra("team1",equipo1)
            val equipo2 = editTeam2.text.toString()
            intent.putExtra("team2",equipo2)
            val estadio = editEstadio.text.toString()
            intent.putExtra("estadio",estadio)
            val referee = editReferee.text.toString()
            intent.putExtra("referee",referee)
            //val replyIntent = Intent()
            startActivity(intent)
            if(TextUtils.isEmpty(editTeam1.text)|| TextUtils.isEmpty(editTeam2.text)||TextUtils.isEmpty(editEstadio.text)||TextUtils.isEmpty(editReferee.text)){
                setResult(Activity.RESULT_CANCELED,intent)
            } else{
                setResult(Activity.RESULT_OK,intent)
            }
            finish()
        }
        btnCancel.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

}
