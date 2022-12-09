package payload;

import com.google.gson.Gson;

import pojos.BookAlmosafer;


public class Payload {

	protected Gson gson = new Gson();

	public String createPayLoad() {
		BookAlmosafer bookAlmosafer = new BookAlmosafer();

		bookAlmosafer.setPropertyId(1534);
		bookAlmosafer.setCheckIn("2022-12-09");
		bookAlmosafer.setCheckOut("2022-12-10");
		return gson.toJson(bookAlmosafer);
	}
}
