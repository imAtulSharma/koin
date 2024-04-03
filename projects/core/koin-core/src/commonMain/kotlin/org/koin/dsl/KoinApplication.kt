/*
 * Copyright 2017-Present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.koin.dsl

import org.koin.core.KoinApplication
import org.koin.core.module.KoinApplicationDslMarker

typealias KoinAppDeclaration = KoinApplication.() -> Unit

/**
 * Create a KoinApplication instance and help configure it
 * @author Arnaud Giuliani
 *
 * @param createEagerInstances - allow to create eager instances or not
 * @param appDeclaration
 */
@KoinApplicationDslMarker
fun koinApplication(createEagerInstances : Boolean = true, appDeclaration: KoinAppDeclaration? = null): KoinApplication {
    val koinApplication = KoinApplication.init()
    appDeclaration?.invoke(koinApplication)
    if (createEagerInstances) {
        koinApplication.createEagerInstances()
    }
    return koinApplication
}
