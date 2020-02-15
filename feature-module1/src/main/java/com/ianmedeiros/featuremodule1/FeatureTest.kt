package com.ianmedeiros.featuremodule1

import com.ianmedeiros.corecontracts.ContractTest
import com.ianmedeiros.coremodule.CoreTest

class FeatureTest : ContractTest {
    fun foo() {
        CoreTest().foo()
    }
}