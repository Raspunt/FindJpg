import java.io.File

class FindJpg(

    var startPos:String

) {


    fun WriteImage() {

        val oldArr = ArrayList<String>()
        val newArr = ArrayList<String>()
        val imageArray = ArrayList<String>()
        var isRun = true



        val file = File(startPos)


        for (f in file.listFiles()) {
//            println(f.absolutePath)

            if (f.isDirectory) {
                oldArr.add(f.absolutePath)
            } else if (f.name.endsWith(".jpg") || f.name.endsWith(".png") ) {
                imageArray.add(f.absolutePath)
            }
        }



        while (isRun) {
            for (ap in oldArr) {
                val f = File(ap)
                if (f.listFiles() != null) {
                    for (lis in f.listFiles()) {
                        if (lis.name.endsWith(".jpg") || lis.name.endsWith(".png")) {
                            imageArray.add(lis.absolutePath)
                        } else if (lis.isDirectory ) {
                            newArr.add(lis.absolutePath)
                        }
                    }
                }
            }
            oldArr.clear()


            for (ap in newArr) {
                val f = File(ap)
                if (f.listFiles() != null) {
                    for (lis in f.listFiles()) {
                        if (lis.endsWith("jpg") || lis.name.endsWith(".png")) {
                            imageArray.add(lis.absolutePath)
                        } else if (lis.isDirectory) {
                            oldArr.add(lis.absolutePath)
                        }
                    }
                }
            }
            newArr.clear()

            val file = File("save.txt")
            val isNewFileCreated :Boolean = file.createNewFile()



            for (ig in imageArray ){
                if (!file.readLines().contains(ig)) {
                    file.appendText(ig + "\n")
                }else{
                    isRun = false
                }





            }




        }

    }
}