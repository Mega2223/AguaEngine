package net.Mega2223.AguaEngine.graphics;

import net.Mega2223.AguaEngine.graphics.objects.Board;
import net.Mega2223.AguaEngine.graphics.objects.GraphicObject;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Shape;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Oval;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Line;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Polygon;
import net.Mega2223.AguaEngine.graphics.objects.shapes.Rectangle;
import net.Mega2223.utils.ImageTools;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {
    public Board board;
    public Renderer() {board = new Board();}
    public Renderer(Board board) {this.board = board; }

    /**Renderiza uma bufferedImage com os objetos do board da classe*/
    public BufferedImage render (){return render(this.board);}
    /**Renderiza uma bufferedImage com os objetos de um board*/
    public static BufferedImage render(Board board) {

        BufferedImage ret = new BufferedImage(board.dim.width,board.dim.height,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics graphics = ret.getGraphics();
        Graphics2D graphics2D = (Graphics2D) graphics;

        for(GraphicObject entAct : board.entities){
            renderShape(ret, entAct.shape, entAct.coords);
        }


        //dependência da aguaLib
        return ImageTools.createFlipped(ret);
    }


    /**Renderiza uma Shape na bufferedimage especificada
     * @param ret Imagem onde eu renderizo
     * @param shape Shape pra ser renderizada
     * @param coords Coordenadas dentro da imagem para serem renderizadas
     * */
    static void renderShape(BufferedImage ret, Shape shape, float[] coords){
        Graphics gr = ret.getGraphics();
        Graphics2D g2d = (Graphics2D) gr;
        g2d.setColor(shape.color);

        switch (shape.type){

            case Shape.SHAPE_OVAL:
                Oval oval = (Oval) shape;
                Dimension dim = new Dimension((int) oval.sizeX, (int) oval.sizeY);
                //System.out.println((int)coords[0] + (int)coords[1] + dim.height + dim.width);
                g2d.drawOval((int)coords[0],(int)coords[1], dim.height, dim.width);
                g2d.fillOval((int)coords[0],(int)coords[1], dim.height, dim.width);
                break;
            case Shape.SHAPE_LINE:
                Line line = (Line) shape;
                g2d.drawLine((int)line.start[0],(int)line.start[1],(int)line.end[0],(int)line.end[1]);
                break;
            case Shape.SHAPE_POLYGON: //todo preencher
                Polygon polygon = (Polygon) shape;
                float[] ant = polygon.points[polygon.points.length-1];
                for(float[] act : polygon.points){
                    g2d.drawLine(
                            (int)(ant[0] + coords[0]),
                            (int)(ant[1] + coords[1]),
                            (int)(act[0] + coords[0]),
                            (int)(act[1] + coords[1]));
                    ant = act;
                    System.out.println((int)ant[0] + "e"+ (int)ant[1] +"e"+(int)act[0] + "e"+(int)act[1]);
                }
                break;
            case Shape.SHAPE_RECTANGLE:
                Rectangle rectangle = (Rectangle) shape;
                g2d.drawRect((int)coords[0],(int)coords[1],(int)rectangle.sizeX,(int)rectangle.sizeY);
                g2d.fillRect((int)coords[0],(int)coords[1],(int)rectangle.sizeX,(int)rectangle.sizeY);
                break;

        }

        g2d.dispose();
        gr.dispose();
    }
}
