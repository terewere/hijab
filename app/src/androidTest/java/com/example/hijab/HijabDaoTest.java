package com.example.hijab;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.hijab.db.HijabDB;
import com.example.hijab.entity.Hijab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


//@RunWith(AndroidJUnit4.class)
public class HijabDaoTest {

    private HijabDB hijabDB;


    @Before
    public void initDb() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        hijabDB = Room.inMemoryDatabaseBuilder(appContext,
                HijabDB.class).build();
    }

    @After
   public void closeDb() {
        hijabDB.close();
    }

    @Test
   public void insertHijab() {
        Hijab hijab = new Hijab("one", "two");

        hijabDB.getHijabDao().insert(hijab);

        LiveData<List<Hijab>> hijabs = hijabDB.getHijabDao().getHijabs();

        assertEquals(hijab, hijabs.getValue());

    }
}
