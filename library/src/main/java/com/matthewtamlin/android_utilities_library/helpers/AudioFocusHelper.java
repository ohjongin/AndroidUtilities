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

package com.matthewtamlin.android_utilities_library.helpers;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

/**
 * Utilities for obtaining and abandoning audio focus.
 */
public abstract class AudioFocusHelper {
	/**
	 * Requests stream music audio focus for the supplied {@code listener}.
	 *
	 * @param context
	 * 		the {@code Context} in which {@code listener} is operating
	 * @param listener
	 * 		the {@code OnAudioFocusChangeListener} to receive the audio focus
	 * @return true if audio focus is granted, false otherwise
	 */
	public static boolean requestStreamMusicFocus(final Context context,
			final OnAudioFocusChangeListener listener) {
		final AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		final int result = am.requestAudioFocus(listener, AudioManager.STREAM_MUSIC,
				AudioManager.AUDIOFOCUS_GAIN);
		return (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED);
	}

	/**
	 * Abandons audio focus from the supplied {@code listener}.
	 *
	 * @param context
	 * 		the {@code Context} in which {@code listener} is operating
	 * @param listener
	 * 		the {@code OnAudioFocusChangeListener} to abandon audio focus
	 */
	public static void abandonFocus(final Context context,
			final OnAudioFocusChangeListener listener) {
		final AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		am.abandonAudioFocus(listener);
	}
}
