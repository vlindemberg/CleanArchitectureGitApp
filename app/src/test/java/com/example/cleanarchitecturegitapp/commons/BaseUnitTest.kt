package com.example.cleanarchitecturegitapp.commons

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule

abstract class BaseUnitTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()
}