/*
 * Copyright 2016 Matthew Tamlin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.matthewtamlin.android_utilities.library.testing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * An activity which hosts a view to be tested, as well as controls for interacting with the view.
 *
 * @param <V>
 * 		the type of view being tested
 * @param <C>
 * 		the type of view which contains the test view
 */
public abstract class TestHarness<V, C> extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * @return the root view of this Activity's layout, not null
	 */
	public abstract View getRootView();

	/**
	 * @return the view which contains the controls, not null
	 */
	public abstract LinearLayout getControlsContainer();

	/**
	 * @return the view under test, not null
	 */
	public abstract V getTestView();

	/**
	 * @return the view which contains the test view
	 */
	public abstract C getTestViewContainer();
}