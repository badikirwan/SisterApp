package com.badikirwan.sisterapp.ui.academic

import com.badikirwan.sisterapp.model.Academic

class AcademicPresenter(view: AcademicContract.View) : AcademicContract.Presenter {

    private val TAG = "Academic Presenter"
    private var view: AcademicContract.View?  = view

    override fun getAcademic() {

    }

    override fun setAcademic() {
        val listAcademic = listOf(
            Academic("PSIKOLOGI KOGNITIF", "WMW1234", 90, "A"),
            Academic("PSIKOLOGI SOSIAL", "WMW321", 85, "A-")
        )

        view?.showAcademic(listAcademic)
    }

    override fun setSemester() {
        val listSemester = arrayOf("Semester 1", "Semester 2", "Semester 3")
        view?.showSemester(listSemester)
    }

    override fun onDestroy() {
        this.view = null
    }

}