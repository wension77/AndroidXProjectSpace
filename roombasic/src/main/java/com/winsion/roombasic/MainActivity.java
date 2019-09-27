package com.winsion.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.winsion.roombasic.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordDatabase wordDatabase;
    private WordDao wordDao;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        wordDatabase = Room.databaseBuilder(this,WordDatabase.class,"word_database")
                .allowMainThreadQueries()
                .build();
        wordDao = wordDatabase.getWordDao();

        updateView();

        binding.btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wordDao.deleteAllWords();
                updateView();
            }
        });

        binding.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wordDao.deleteWords();
            }
        });

        binding.btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word1 = new Word("hello" ,"你好");
                Word word2 = new Word("word","世界");
                wordDao.insertWords(word1,word2);
                updateView();
            }
        });

        binding.btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("hello","你好呀！");
                word.setId(70);
                wordDao.updateWords(word);
                updateView();
            }
        });

        binding.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("hello","你好呀！");
                word.setId(63);
                wordDao.deleteWords(word);
                updateView();
            }
        });
    }

    private void updateView() {
        List<Word> allWords = wordDao.getAllWords();
        String text = "";
        for (int i = 0;i<allWords.size();i++){
            Word word = allWords.get(i);
            text += word.getId() + ":" + word.getWord() + "=" + word.getChineseMeaning() + "\n";
        }
        binding.textView.setText(text);
    }
}
