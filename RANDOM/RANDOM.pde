float trans;
void setup() {

	size(512, 512,P3D);
	

}

void draw() {

	trans = map(mouseX, 0, width, -20, -100);
	for (int z = 0; z < 10; ++z) {
		translate(0, 0, z*(trans));
		for (int x = 0; x < 10; ++x) {

			for (int y = 0; y < 10; ++y) {
				rect(x*40, y*40, 30, 30);
				
				
			}
		}

	}



}



