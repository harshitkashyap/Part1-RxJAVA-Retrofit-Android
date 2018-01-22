package com.example.harshit.part1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.Observable;

import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import io.reactivex.schedulers.Schedulers;




public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Worldpopulation> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);






        getImage();
    }


    public void getImage(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.androidbegin.com/tutorial/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Service apiService = retrofit.create(Service.class);


        Observable<ImageModel> observable=apiService.getimagedata().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<ImageModel>() {


            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ImageModel imageModel) {
                Toast.makeText(getApplicationContext(),imageModel.getWorldpopulation()[1].getCountry(),
                        Toast.LENGTH_SHORT).show();



                list = new ArrayList<>();
                for (int i =0;i<imageModel.getWorldpopulation().length;i++){

                    Worldpopulation block=new Worldpopulation();

                    block.setCountry(imageModel.getWorldpopulation()[i].getCountry());
                    block.setPopulation(imageModel.getWorldpopulation()[i].getPopulation());
                    block.setFlag(imageModel.getWorldpopulation()[i].getFlag());







                    list.add(block);
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new RecyclerAdapter(list,getApplicationContext()));




            }

            @Override
            public void onError(Throwable e) {

                Log.e("yoo","kya error hai bhai:",e);

            }

            @Override
            public void onComplete() {

            }
        });


    }



}
