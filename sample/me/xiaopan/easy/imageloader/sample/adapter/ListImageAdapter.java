/*
 * Copyright 2013 Peng fei Pan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.easy.imageloader.sample.adapter;

import me.xiaoapn.easy.imageloader.ImageLoader;
import me.xiaoapn.easy.imageloader.R;
import me.xiaoapn.easy.imageloader.process.RoundedCornerBitmapProcessor;
import me.xiaoapn.easy.imageloader.task.Options;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ListImageAdapter extends BaseAdapter {
	private Context context;
	private String[] imageUrls;
	private Options options;
	
	public ListImageAdapter(Context context, String[] imageUrls){
		this.context = context;
		this.imageUrls = imageUrls;
		options = ImageLoader.getInstance().getConfiguration().getDefaultOptions().copy();
		options.setBitmapProcessor(new RoundedCornerBitmapProcessor());
	}

	@Override
	public Object getItem(int position) {
		return imageUrls[position];
	}

	@Override
	public int getCount() {
		return imageUrls.length;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.list_item_image, null);
			viewHolder.image = (ImageView) convertView.findViewById(R.id.image_listItem);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
//		ImageLoader.getInstance().display(imageUrls[position], viewHolder.image, options);
		ImageLoader.getInstance().display(imageUrls[position], viewHolder.image);
		return convertView;
	}
	
	class ViewHolder{
		ImageView image;
	}
}