package edu.montclair.vasquezm15.gpacalc;

//Michael Vasquez
//03/07/21
//mobile computing
//Assignment 2
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private float m = 0; // setting a float count to 0 which will be used to clear and compute the grades
    private EditText grades1; //variable for grade1 while to clear it as well with another variable to calculate the grades
    private EditText grades2; //variable for grade2 while to clear it as well with another variable to calculate the grades
    private EditText grades3; // variable for grade3 while to clear it as well with another variable to calculate the grades
    private EditText grades4; // variable for grade4 while to clear it as well with another variable to calculate the grades
    private EditText grades5; // variable for grade5 while to clear it as well with another variable to calculate the grades
    private TextView label; //Label to display the gpa while calcaluted
    private TextView bg;// this variable well be to change the background color of within the gpa
    private Button computegpa; // A variable while the button is clicked



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        grades1 = findViewById(R.id.grade1); //setting a variable to our id of our input number fields.
        grades2 = findViewById(R.id.grade2); //setting a variable to our id of our input number fields.
        grades3 = findViewById(R.id.grade3); //setting a variable to our id of our input number fields.
        grades4 = findViewById(R.id.grade4); //setting a variable to our id of our input number fields.
        grades5 = findViewById(R.id.grade5); //setting a variable to our id of our input number fields.
        label = findViewById(R.id.display); // setting our label to display that will display while the grades are computed.
        bg = findViewById(R.id.background); // I set a variable bg to our background id to display while the grades are computed the background will change.
        final Button computegpa = findViewById(R.id.compute); // i made a variable computegpa to our id compute which is our button
        computegpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float course1,course2,course3,course4,course5; // our float will take the decimal points after it sums up the average in our calculator
                if (m % 2 == 0) { // i decided to write a variable m because this variable is making it equal to and that so the clear and compute functionality can work.
                    if (grades1.getText().toString().equals("") || grades2.getText().toString().equals("") || grades3.getText().toString().equals("") || grades4.getText().toString().equals("") || grades5.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Please Insert grades", Toast.LENGTH_SHORT).show(); // So in this block of code i basically wrote a statement if no number are entered you will get a toast to "Please Insert grades"
                    } else {

                        course1 = Float.parseFloat(grades1.getText().toString()); //So, i am basically saying take grade 1 input of its data
                        course2 = Float.parseFloat(grades2.getText().toString()); // So, this line is taking data from grade2 that we put in
                        course3 = Float.parseFloat(grades3.getText().toString()); // this line is taking the data from grade3
                        course4 = Float.parseFloat(grades4.getText().toString()); // this line is taking the data from grade4
                        course5 = Float.parseFloat(grades5.getText().toString()); // this line is taking the data from grade5
                        float TotalAverage = course1 + course2 + course3 + course4 + course5; // so once we obtained grades from 1-5 we take the average and add them all up.
                        TotalAverage = TotalAverage / 5; // once we added all the grades now we can proceed to divide by 5 to get our Average Gpa

                        if
                        (TotalAverage < 60) { // So now i made a statement saying while total is 60 of the average the background color will display red.
                            label.setText(Float.toString(TotalAverage));
                            bg.setBackgroundColor(Color.RED); // background will change to red


                        } else if
                        (TotalAverage > 60 && TotalAverage < 80) { //This statement is between through 61-79 the background color will change yellow, which 80 is less than TotalAverage and 60 is greater than total average to turn yellow
                            label.setText(Float.toString(TotalAverage));
                            bg.setBackgroundColor(Color.YELLOW); // background will change to yellow

                        } else if
                        (TotalAverage > 80 && TotalAverage <= 100) { // While this is greater than 80 of the average and less to equal to 100 of the averages the background color will change to green. Which in the assignment is 80-100
                            label.setText(Float.toString(TotalAverage));
                            bg.setBackgroundColor(Color.GREEN); // background will change to green
                        }
                        computegpa.setText("Clear");  // in this statement were saying once the gpa are computed the button will switch to clear.
                        m++;
                        Toast.makeText(MainActivity.this, "Successful Computed.", Toast.LENGTH_SHORT).show(); // Toast that Compute was Successful

                    }
                } else {
                    m++;
                    label.setText("........."); //once clear the display of the computing go back to normal which is clear.
                    grades1.setText(""); // Once clear the grade 1 clears its field.
                    grades2.setText(""); // Once clear the grade 2 clears its field.
                    grades3.setText(""); // Once clear the grade 3 clears its field.
                    grades4.setText(""); // Once clear the grade 4 clears its field.
                    grades5.setText(""); // Once clear the grade 5 clears its field.
                    bg.setBackgroundColor(Color.WHITE); //once clear the background changes back to white
                    computegpa.setText("COMPUTE GPA"); // once clear the button COMPUTE GPA comes back to input another set of grades to compute again!
                    Toast.makeText(MainActivity.this, "The Averages have been Cleared.", Toast.LENGTH_SHORT).show(); //Toast that Averages have been cleared
                }
            }
        });
    }
}

