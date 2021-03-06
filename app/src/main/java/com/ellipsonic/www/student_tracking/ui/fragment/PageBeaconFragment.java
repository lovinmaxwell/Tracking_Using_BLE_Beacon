/*
 *
 *  Copyright (c) 2015 SameBits UG. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ellipsonic.www.student_tracking.ui.fragment;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ellipsonic.www.student_tracking.Student_Tracking;
import com.ellipsonic.www.student_tracking.data.DataManager;
import com.ellipsonic.www.student_tracking.model.ActionBeacon;
import com.ellipsonic.www.student_tracking.util.Constants;

/**
 * Created by vitas on 20/12/15.
 */
public abstract class PageBeaconFragment extends PreferenceFragmentCompat {

    protected DataManager mDataManager;
    protected ActionBeacon mActionBeacon;
    protected int mPage;

    abstract public void onCreatePreferences(Bundle savedInstanceState, String rootKey);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = Student_Tracking.from(getActivity()).getComponent().dataManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = super.onCreateView(inflater, container, savedInstanceState);

        readArguments();
        setData();

        return fragmentView;
    }

    protected abstract void setData();

    protected void readArguments() {
        if (getArguments() != null) {
            mPage = getArguments().getInt(Constants.ARG_PAGE);
            mActionBeacon = getArguments().getParcelable(Constants.ARG_ACTION_BEACON);
        }
    }

    protected boolean updateActionBeacon() {
        return mDataManager.updateBeaconAction(mActionBeacon);
    }


}
