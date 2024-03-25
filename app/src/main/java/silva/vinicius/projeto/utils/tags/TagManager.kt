package silva.vinicius.projeto.utils.tags

import java.util.ArrayList

class TagManager {
    private val TAG_LIMIT: Int = 5
    private val TAG_LIST: ArrayList<String> = ArrayList()

    fun addItem(item: String) {
        TAG_LIST.add(item)
    }

    fun removeItem(item: String){
        TAG_LIST.remove(item)
    }

    fun isListFull(): Boolean{
        return TAG_LIST.size >= TAG_LIMIT
    }

    fun getList(): String{
        return TAG_LIST.toString()
    }

    fun getSize(): Int{
        return TAG_LIST.size
    }

    fun isListValid(): Boolean{
        return TAG_LIST.size != 0
    }
}
