package attister.com.attister;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {

    EditText etDOB;
    private String date="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etDOB = findViewById(R.id.dob);

        etDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateFunction();
            }
        });
    }

    private void dateFunction() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        DateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                        DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String inputDateStr = date;
                        Date datenew = null;
                        try {
                            datenew = inputFormat.parse(inputDateStr);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        date = outputFormat.format(datenew);
                        etDOB.setText(date);


                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }
}
