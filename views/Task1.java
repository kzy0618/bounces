package bounce.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import bounce.NestingShape;
import bounce.Shape;
import bounce.ShapeModel;

public class Task1 implements TreeModel {

	protected ShapeModel _adaptee;

	protected List<TreeModelListener> _treeModelListeners;

	public Task1(ShapeModel model) {
		
		_adaptee=model;
		
		_treeModelListeners = new ArrayList<TreeModelListener>();
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		_treeModelListeners.add(l);
	}

	@Override
	public Object getChild(Object parent, int index) {
		Object result = null;

		try{if(parent instanceof NestingShape){
			NestingShape nestingshape=(NestingShape) parent;
			result=nestingshape.shapeAt(index);
		}
		}catch(IndexOutOfBoundsException e){
		}
		return result;
	}

	@Override
	public int getChildCount(Object parent) {
		int result = 0;
		Shape shape = (Shape) parent;

		if(shape instanceof NestingShape){
			NestingShape nestingshape=(NestingShape) shape;
			result=nestingshape.shapeCount();
		}
		return result;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		int indexOfChild = -1;

		if(parent instanceof NestingShape){
			NestingShape nest = (NestingShape) parent;
			Shape shape = (Shape) child;
			indexOfChild = nest.indexOf(shape);
		}
		return indexOfChild;
	}

	@Override
	public Object getRoot() {
		return _adaptee.root();
	}

	@Override
	public boolean isLeaf(Object node) {
		return !(node instanceof NestingShape);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		_treeModelListeners.remove(1);

	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub

	}
}
