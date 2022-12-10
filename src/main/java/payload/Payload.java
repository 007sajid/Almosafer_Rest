package payload;

import com.google.gson.Gson;

import pojos.BookAlmosafer;


public class Payload {

	protected Gson gson = new Gson();

	public String createPayLoad(String checkIn , String checkOut) {
		BookAlmosafer bookAlmosafer = new BookAlmosafer();

		bookAlmosafer.setPropertyId(1534);
		bookAlmosafer.setCheckIn(checkIn);
		bookAlmosafer.setCheckOut(checkOut);
		return gson.toJson(bookAlmosafer);
	}
}
