package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.concurrent.TimeUnit;


//0 gold
//1 bronz
//2 empty

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img,sky,background,characker,cloud,coinsilver,coingold,moons;
	private BitmapFont font,fonts;
	String mert="Run Cooper Run",touch="Touch for Start";
	public int b=0,c=0,a=0,d,e,f,g,score;
	private float timeSeconds = 0f,period = 1f;
	private Sprite sprite;
	TextureRegion deneme,denemes;
	boolean first=true,zipla=false,high=true,aldinmi=false,scores=false;

	@Override
	public void create () {
		batch = new SpriteBatch();
		fonts = new BitmapFont();
		fonts.setColor(Color.WHITE);
		fonts.getData().setScale(6);
		font = new BitmapFont();
		font.setColor(Color.RED);
		font.getData().setScale(8);
		sky = new Texture("_11_background.png");
		background = new Texture("_04_bushes.png");
		img = new Texture("_01_ground.png");
		characker = new Texture("adventurer-Sheet.png");
		cloud = new Texture("_08_clouds.png");
		moons = new Texture("Idles.png");
		coingold = new Texture("faceon_gold_coin.png");

		d=Gdx.graphics.getHeight() / 5;
		//sprite.setRotation(45);
		denemes = new TextureRegion(moons,0,0,150,150);
		Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Eric-Skiff.mp3"));
		menuMusic.setLooping(true);
		menuMusic.play();


	}

	@Override
	public void render () {
		if (zipla){
			deneme = new TextureRegion(characker,1*50,3*37,50,37);
		}else {
			deneme = new TextureRegion(characker,a*50,37,50,37);
		}
		sprite = new Sprite(deneme);
		sprite.setPosition(200,d);
		sprite.setSize(300,300);
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(sky, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(cloud, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(background, b, Gdx.graphics.getHeight()/8,3000, Gdx.graphics.getHeight());
		batch.draw(background, c+2000, Gdx.graphics.getHeight()/8,3000, Gdx.graphics.getHeight());
		batch.draw(img, b, 0,3000, Gdx.graphics.getHeight());
		batch.draw(img, c+2000, 0,3000, Gdx.graphics.getHeight());

		if (scores) {
			fonts.draw(batch, "Score:" + String.valueOf(score), 0, 19 * Gdx.graphics.getHeight() / 20);
		}
		if (first) {
			font.draw(batch, mert, Gdx.graphics.getWidth() / 4, 3 * Gdx.graphics.getHeight() / 4);
			fonts.draw(batch, touch, Gdx.graphics.getWidth() / 4, 2 * Gdx.graphics.getHeight() / 4 + 10);
			e=3*Gdx.graphics.getWidth()/2 ;
			f=2*Gdx.graphics.getWidth() ;
			g=5*Gdx.graphics.getWidth()/2 ;
			aldinmi=false;
		}
	//	batch.draw(deneme, 500, 100);
		sprite.draw(batch);


		batch.draw(denemes, e-100, 3*Gdx.graphics.getHeight() / 6,Gdx.graphics.getHeight()/2, Gdx.graphics.getHeight()/2);


		batch.draw(coingold, e, Gdx.graphics.getHeight() / 4,Gdx.graphics.getHeight()/6, Gdx.graphics.getHeight()/6);


		batch.draw(coingold, g, 3*Gdx.graphics.getHeight() / 5,Gdx.graphics.getHeight()/6, Gdx.graphics.getHeight()/6);



		batch.draw(denemes, g-100, Gdx.graphics.getHeight() / 6,Gdx.graphics.getHeight()/2, Gdx.graphics.getHeight()/2);


		batch.draw(denemes, f-100, 3*Gdx.graphics.getHeight() / 6,Gdx.graphics.getHeight()/2, Gdx.graphics.getHeight()/2);

		if (e<=Gdx.graphics.getWidth()/5 && Gdx.graphics.getHeight()/2>=d && !aldinmi){
			score++;
			aldinmi=true;

		}else if (e>=Gdx.graphics.getWidth()/10 &&e<=Gdx.graphics.getWidth()/5 && 2*Gdx.graphics.getHeight()/5<=d ){
			first=true;
			mert="Game Over";
			touch="Score:"+String.valueOf(score);
			score=0;
			scores=false;

		}

		if (g<=Gdx.graphics.getWidth()/5 && Gdx.graphics.getHeight()/2<=d && !aldinmi){
			score++;
			aldinmi=true;
		}else if (g>=Gdx.graphics.getWidth()/10 && g<=Gdx.graphics.getWidth()/5 && 2*Gdx.graphics.getHeight()/5>=d ){
			first=true;
			mert="Game Over";
			touch="Score:"+String.valueOf(score);
			score=0;
			scores=false;

		}

		if (f>=Gdx.graphics.getWidth()/10 && f<=Gdx.graphics.getWidth()/5 && 2*Gdx.graphics.getHeight()/5<=d ){
			first=true;
			mert="Game Over";
			touch="Score:"+String.valueOf(score);
			score=0;
			scores=false;

		}

		//batch.draw(coingold, e, Gdx.graphics.getHeight() / 4,Gdx.graphics.getHeight()/6, Gdx.graphics.getHeight()/6);


		batch.end();
		if(Gdx.input.isTouched()){
			if (!first && !zipla){
				zipla=true;
			}

			if (first){
				first=false;
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

		if (e<0){
			e=3*Gdx.graphics.getWidth()/2 ;
			aldinmi=false;
		}
		if (g<0){
			g=3*Gdx.graphics.getWidth()/2 ;
			aldinmi=false;
		}
		if (f<0){
			f=3*Gdx.graphics.getWidth()/2 ;
			aldinmi=false;
		}






		if (zipla){
			if (high && 3*Gdx.graphics.getHeight() / 5>=d ){
				d=5+d;
			}else if (!high) {
				d=d-5;
			}else  {
				high = false;
			}

			if ( Gdx.graphics.getHeight() / 5 >= d){
				zipla=false;
				high=true;
			}

		}
		handleEvents();

		if (b<=-2999){
			b=c+4000;
		}
		if (c<=-5000){
			c=b;
		}

		if (a==7){
			a=0;
		}


	}



	@Override
	public void dispose () {
		font.dispose();
		batch.dispose();
		img.dispose();
	}

	public void handleEvents() {
		if (!first){
			b=b-7;
			c=c-7;
			a++;
			e=e-10;
			f=f-10;
			g=g-10;
			scores=true;
		}

	}
}


