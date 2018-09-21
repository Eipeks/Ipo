package com.ayokunlepaul.ipo

import com.ayokunlepaul.ipo.core.Placemark
import com.ayokunlepaul.ipo.core.persistence.IpoPersistenceManager
import com.ayokunlepaul.ipo.screens.MainActivityViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Mock
    private lateinit var preferenceManager: IpoPersistenceManager

    private lateinit var viewModel: MainActivityViewModel

    @Before
    fun setupMocks() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainActivityViewModel(preferenceManager)
    }

    @Test
    fun checkForSavedPlaceMark() {
        Mockito.`when`(viewModel.getPlacemark()).thenReturn(Placemark("Lesserstraße 170, 22049 Hamburg", listOf(10.07526,53.59301),
                "CE", "UNACCEPTABLE", 42, "UNACCEPTABLE", "HH-GO8522", "WME4513341K565439"))

        val testPlacemark = Placemark("Lesserstraße 170, 22049 Hamburg", listOf(10.07526,53.59301),
                "CE", "UNACCEPTABLE", 42, "UNACCEPTABLE", "HH-GO8522", "WME4513341K565439")
        assertEquals(testPlacemark, viewModel.getPlacemark())
    }
}
