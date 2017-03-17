package bounce.views;

import javax.swing.event.TreeModelEvent;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeModel;

import bounce.NestingShape;
import bounce.Shape;
import bounce.ShapeModel;
import bounce.ShapeModelEvent;
import bounce.ShapeModelListener;

public class Task2 extends Task1 implements ShapeModelListener{

	public Task2(ShapeModel _model) {
		super(_model);
	}

	@Override
	public void update(ShapeModelEvent event) {
		ShapeModelEvent.EventType eventType = event.eventType();
		ShapeModel source = event.source();
		int[] childIndices = {event.index()};
		Object[] children = {event.operand()};
		
		if(eventType == ShapeModelEvent.EventType.ShapeAdded) {
			
			TreeModelEvent e = new TreeModelEvent(source,event.parent().path().toArray(),childIndices,children);
			
			for(TreeModelListener l : _treeModelListeners){
				l.treeNodesInserted(e);
			}
			
		}else if(eventType == ShapeModelEvent.EventType.ShapeRemoved) {
			
			TreeModelEvent e = new TreeModelEvent(source,event.parent().path().toArray(),childIndices,children);
			
			for(TreeModelListener l : _treeModelListeners){
				l.treeNodesRemoved(e);
			}
		}

	}
}