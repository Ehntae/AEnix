package net.Elerion.AEnix;

import net.Elerion.AEnix.Actors.Player;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class AEnix extends BasicGame {

	public AEnix( String Title ){ super( Title ); }
	
	Player Pl;
	Grid CellGrid;
	Grid SectGrid;
	Grid AreaGrid;
	

	@Override
	public void init( GameContainer Frame ) throws SlickException {
		
		Frame.setAlwaysRender( true );
		Frame.setClearEachFrame( true );
		Frame.setForceExit( true );
		Frame.setSmoothDeltas( true );
		Frame.setVerbose( true );
		Frame.setTargetFrameRate( 60 );
		
		CellGrid = new Grid( 16, Conf.AEnix.Res );
		SectGrid = new Grid( 32, Conf.AEnix.Res );
		AreaGrid = new Grid( 64, Conf.AEnix.Res );
		
		
		Pl = new Player( new Vector2f(256f,256f), 16, 16, new Color(30,70,120) );
		
		
	}

	@Override
	public void update( GameContainer Frame, int Delta ) throws SlickException {
		
		
	}
	
	public void keyPressed( int Num, char Key ){
		
		
		if ( Key == 'w' ){ tick.addCmd( Pl.moveUp() ); Pl.ghost.moveUp( ); }
		if ( Key == 's' ){ tick.addCmd( Pl.moveDown() ); Pl.ghost.moveDown( ); }
		if ( Key == 'a' ){ tick.addCmd( Pl.moveLeft() ); Pl.ghost.moveLeft( ); }
		if ( Key == 'd' ){ tick.addCmd( Pl.moveRight() ); Pl.ghost.moveRight( ); }
		
		if ( Key == ' ' ){ tick.exec( ); }
		
	}
	
	@Override
	public void render( GameContainer Frame, Graphics Rend ) throws SlickException {
		
		Rend.setAntiAlias( true );
		
		//| ACTORS
		Rend.setColor( Pl.Clr );
		Rend.fill( Pl.Elm );
		Rend.draw( Pl.Elm );
		Rend.draw( Pl.ghost.Elm );
		
		
		//| GRIDS
		Rend.setColor( new Color( 50, 10, 10, 0.05f ) );
		for ( Rectangle C : CellGrid.Elms ){
			Rend.draw( C );
		}
		
		
	}
	
	
}





