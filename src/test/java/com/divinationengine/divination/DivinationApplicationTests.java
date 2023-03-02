package com.divinationengine.divination;

import com.divinationengine.divination.models.Reading;
import com.divinationengine.divination.repository.CardRepository;
import com.divinationengine.divination.repository.ReadingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class DivinationApplicationTests {

	@Autowired
	CardRepository cardRepository;

	@Autowired
	ReadingRepository readingRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void createReadingThenSave(){

		Reading readingName = new Reading();
		readingRepository.save(readingName);
	}
}
