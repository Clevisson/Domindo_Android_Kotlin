package dominando.android.fragments

class HotelListPresenter (
    private val view: HotelListView,
    private val repository: HotelRepository
){
    fun searchHotels(term: String) {
        repository.search(term) { hotels ->
            view.showHotels(hotels)
        }
    }
    fun selectHotel(hotel: Hotel) {
        view.showHotelDetails(hotel)
    }
}