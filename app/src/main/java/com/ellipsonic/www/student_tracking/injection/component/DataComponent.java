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

package com.ellipsonic.www.student_tracking.injection.component;

import com.ellipsonic.www.student_tracking.data.DataManager;
import com.ellipsonic.www.student_tracking.injection.UserScope;
import com.ellipsonic.www.student_tracking.injection.module.DataModule;

import dagger.Component;

@UserScope
@Component(dependencies = ApplicationComponent.class, modules = {DataModule.class})
public interface DataComponent {

    void inject(DataManager dataManager);

}