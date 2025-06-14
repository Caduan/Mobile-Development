package com.example.application8;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
	public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
		super(context, workerParams);
	}

	@NonNull @Override public Result doWork() {
		String taskName = getInputData().getString("task");
		Log.d("WORKER", "ЗАПУСКАЕТСЯ " + taskName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			return Result.failure();
		}
		Log.d("WORKER", "ЗАПУСКАЕТСЯ " + taskName);
		return Result.success();
	}
}