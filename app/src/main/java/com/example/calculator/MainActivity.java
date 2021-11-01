package com.example.calculator;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.databinding.ActivityMainBinding;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    int openParenCount = 0;
    int closeParenCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.oneBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("1");
            }
        });

        binding.twoBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("2");
            }
        });

        binding.threeBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("3");
            }
        });

        binding.fourBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("4");
            }
        });

        binding.fiveBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("5");
            }
        });

        binding.sixBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("6");
            }
        });

        binding.sevenBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("7");
            }
        });

        binding.eightBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("8");
            }
        });

        binding.nineBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("9");
            }
        });

        binding.zeroBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].equals(")")) {
                binding.line2.append("0");
            }
        });

        binding.decimalBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (!strArray[strArray.length - 1].contains(".")) {
                binding.line2.append(".");
            }
        });

        binding.clearBtn.setOnClickListener(v -> {
            binding.line1.setText("");
            binding.line2.setText("");
        });

        binding.addBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (Calc.isNumber(strArray[strArray.length - 1]) || strArray[strArray.length - 1].equals(")")) {
                binding.line2.append(" + ");
            }
        });

        binding.subtractBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (Calc.isNumber(strArray[strArray.length - 1]) || strArray[strArray.length - 1].equals(")")) {
                binding.line2.append(" - ");
            }
        });

        binding.multiplyBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (Calc.isNumber(strArray[strArray.length - 1]) || strArray[strArray.length - 1].equals(")")) {
                binding.line2.append(" * ");
            }
        });

        binding.divideBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");
            if (Calc.isNumber(strArray[strArray.length - 1]) || strArray[strArray.length - 1].equals(")")) {
                binding.line2.append(" / ");
            }
        });

        binding.deleteBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            if (equation.endsWith(" ")) {
                binding.line2.setText(equation.substring(0, equation.length() - 2));
            } else {
                binding.line2.setText(equation.substring(0, equation.length() - 1));
            }
        });

        binding.equalsBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

            try {
                binding.line1.setText(equation);
                String answer = engine.eval(equation).toString();
                if (answer.endsWith(".0")) {
                    answer = answer.substring(0, answer.length() - 2);
                }
                binding.line2.setText(answer);
            } catch (ScriptException e) {
                Log.d("Logger", equation);
                e.printStackTrace();
            }
        });

        binding.openParenthesisBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");

            if (!Calc.isNumber(strArray[strArray.length - 1])) {
                openParenCount++;
                binding.line2.append(" ( ");
            } else if (equation.length() == 0) {
                openParenCount++;
                binding.line2.append("( ");
            }
        });

        binding.closedParenthesisBtn.setOnClickListener(v -> {
            String equation = binding.line2.getText().toString();
            String[] strArray = equation.split(" ");

            boolean isNumOrClosedParen = Calc.isNumber(strArray[strArray.length - 1]) || strArray[strArray.length - 1].equals(")");

            if (isNumOrClosedParen && closeParenCount < openParenCount) {
                closeParenCount++;
                binding.line2.append(" ) ");
            }
        });

    }
}