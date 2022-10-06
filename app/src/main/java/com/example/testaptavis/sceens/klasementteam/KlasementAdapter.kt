package com.example.testaptavis.sceens.klasementteam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testaptavis.R
import com.example.testaptavis.databinding.ItemKlasementBinding
import com.example.testaptavis.model.TeamModel

class KlasementAdapter(
    private var list: List<TeamModel>
) : RecyclerView.Adapter<KlasementAdapter.ViewHolder>() {

    fun setData(list: List<TeamModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_klasement, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemKlasementBinding.bind(itemView)

        fun binData(data: TeamModel) {
            binding.run {
                txtNameKlub.text = data.name

                val match = data.match.toString()
                if (match == "null") {
                    txtMatch.text = "-"
                } else txtMatch.text = match


                val win = data.win.toString()
                if (win == "null") {
                    txtWin.text = "-"
                } else txtWin.text = win


                val draw = data.draw.toString()
                if (draw == "null") {
                    txtDraw.text = "-"
                } else txtDraw.text = draw


                val lose = data.lose.toString()
                if (lose == "null") {
                    txtLose.text = "-"
                } else txtLose.text = lose


                val point = data.point.toString()
                if (point == "null") {
                    txtPoint.text = "-"
                } else txtPoint.text = point

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}